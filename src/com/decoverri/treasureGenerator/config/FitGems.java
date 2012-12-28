package com.decoverri.treasureGenerator.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.GemGradeDao;
import com.decoverri.treasureGenerator.dao.GemstoneDao;
import com.decoverri.treasureGenerator.model.GemGrade;
import com.decoverri.treasureGenerator.model.Gemstone;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitGems {

	private Session session;

	public FitGems(Session session) {
		this.session = session;
	}

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("gem", Gemstone.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/gems.txt"));
		while (scanner.hasNextLine()) {
			Gemstone gem = (Gemstone) xstream.fromXML(scanner.nextLine());
			GemstoneDao gemDao = new GemstoneDao(session);
			if (!gemDao.exists(gem.getName())) {
				GemGradeDao gradeDao = new GemGradeDao(session);
				GemGrade gradeSearch = gradeDao.searchByGradeNumber(gem.getGrade());
				if (gradeSearch == null) {
					gradeDao.save(gem.getGrade());
				} else {
					gem.setGrade(gradeSearch);
				}
				gemDao.saveOrUpdate(gem);
			}
		}
		scanner.close();
	}

}
