package com.ligui.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.ligui.pojo.Account;
import com.ligui.pojo.Log;
import com.ligui.service.AccountService;

public class AccountServiceImpl implements AccountService{

	@SuppressWarnings("deprecation")
	@Override
	public int transfer(Account accIn, Account accOut) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
		Account accOutselect = session.selectOne("com.ligui.mapper.AccountMapper.selByAccnoPwd",accOut);
		if(accOutselect!=null) {
		if(accOutselect.getBalance()>=accOut.getBalance()) {
			boolean flag=accOut.getAccNo().equals(accIn.getAccNo());
			Account accIutselect=session.selectOne("com.ligui.mapper.AccountMapper.selByAccnoName", accIn);
			if(accIutselect!=null&&flag==false) {
				accIn.setBalance(accOut.getBalance());
				accOut.setBalance(-accOut.getBalance());
				int index=session.update("com.ligui.mapper.AccountMapper.updByBalanceAccno", accOut);
				index += session.update("com.ligui.mapper.AccountMapper.updByBalanceAccno", accIn);
				if(index==2) {
					Log log=new Log();
					log.setAccin(accIn.getAccNo());
					log.setAccout(accOut.getAccNo());
					log.setMoney(accIn.getBalance());
					log.setName(accIn.getName());
					session.insert("com.ligui.mapper.logMapper.inslog", log);
					Logger logger= Logger.getLogger(AccountServiceImpl.class);
					//自定义日志记录
					logger.info(new Date().toLocaleString()+":"+log.getAccout()+"转账到"+log.getAccin()+"的账户"+log.getMoney()+"元");
					session.commit();
					session.close();
					return SUCCESS;
				}else {
					session.rollback();
					session.close();
					return ERROR;
				}
			}else {
				return ACCOUNT_NAME_NOT_MATCH;
			}
		}else {
			return ACCOUNT_BANANCE_NOT_ENOUGH;
		}
		}else {
			return ACCOUNT_PASSWORD_NOT_MATCH;
		}

	}

}
