package com.decoverri.treasureGenerator.aux.fitData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.data.dao.ArtObjectGeneratorDataDao;
import com.decoverri.treasureGenerator.data.model.ArtObjectGeneratorData;
import com.decoverri.treasureGenerator.reward.dao.CTreasureRewardDao;
import com.decoverri.treasureGenerator.reward.model.CTreasureReward;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class FitTreasureC {

	private Session session;

	public FitTreasureC(Session session) {
		this.session = session;
	}

	public void fit() throws IOException {

		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("reward", CTreasureReward.class);
		xstream.alias("artgenerator", ArtObjectGeneratorData.class);

		Scanner scanner = new Scanner(new FileInputStream("dataInTxt/CTreasureReward.txt"));
		while (scanner.hasNextLine()) {
			CTreasureReward reward = (CTreasureReward) xstream.fromXML(scanner.nextLine());

			ArtObjectGeneratorDataDao artGenDao = new ArtObjectGeneratorDataDao(session);
			CTreasureRewardDao rewardDao = new CTreasureRewardDao(session);

			for (ArtObjectGeneratorData artGen : reward.getArts()) {
				artGenDao.save(artGen);
			}
			rewardDao.save(reward);

		}
		scanner.close();
	}
}
