package com.decoverri.treasureGenerator.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.decoverri.treasureGenerator.dao.treasure.StaffDao;
import com.decoverri.treasureGenerator.model.treasure.Staff;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitStaff {

	@Autowired
	private StaffDao staffDao;

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("staff", Staff.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/staves.json"));
		while (scanner.hasNextLine()) {
			Staff staff = (Staff) xstream.fromXML(scanner.nextLine());
			staffDao.saveOrUpdate(staff);
		}
		scanner.close();
	}

}
