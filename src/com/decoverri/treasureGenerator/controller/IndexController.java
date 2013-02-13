package com.decoverri.treasureGenerator.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.decoverri.treasureGenerator.config.HibernateUtil;
import com.decoverri.treasureGenerator.dao.TreasureRewardDao;
import com.decoverri.treasureGenerator.model.view.TreasureTypeInfo;

@Controller
public class IndexController {
	
	//TODO: Session must go to a Filter or Interceptor
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	@RequestMapping("/")
	public ModelAndView execute() {

		ArrayList<TreasureTypeInfo> list = new ArrayList<TreasureTypeInfo>();
		TreasureTypeInfo info;
		
		Transaction transaction = session.beginTransaction();
		TreasureRewardDao dao = new TreasureRewardDao(session);

		List<Character> types = dao.getTypes();
		
		for (Character character : types) {
			info = new TreasureTypeInfo();
			info.setName(character.toString());
			info.setValues(dao.getValuesOfType(character));
			list.add(info);
		}
		
		transaction.commit();

		ModelAndView mv = new ModelAndView("index");
		mv.addObject("treasureTypesInfo", list);
		
		return mv;
	}

}
