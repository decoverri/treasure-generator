package com.decoverri.treasureGenerator.aux.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.treasure.aux.model.StaffDao;
import com.decoverri.treasureGenerator.treasure.model.Staff;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitStaff {

	private Session session;

	public FitStaff(Session session) {
		this.session = session;
	}

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("staff", Staff.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/staves.txt"));
		while (scanner.hasNextLine()) {
			Staff staff = (Staff) xstream.fromXML(scanner.nextLine());
			StaffDao staffDao = new StaffDao(session);
			staffDao.saveOrUpdate(staff);
		}
		scanner.close();
	}

}
