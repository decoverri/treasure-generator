package com.decoverri.treasureGenerator.config.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.dao.generator.ArtObjectGeneratorDataDao;
import com.decoverri.treasureGenerator.dao.reward.CTreasureRewardDao;
import com.decoverri.treasureGenerator.model.generator.ArtObjectGeneratorData;
import com.decoverri.treasureGenerator.model.reward.CTreasureReward;
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
