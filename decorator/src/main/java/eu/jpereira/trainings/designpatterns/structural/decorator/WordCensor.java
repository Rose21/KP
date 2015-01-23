package eu.jpereira.trainings.designpatterns.structural.decorator;

import eu.jpereira.trainings.designpatterns.structural.decorator.channel.decorator.SocialChannelDecorator;

public class WordCensor extends SocialChannelDecorator {
	
	private String[] blockedWords; 
	
	WordCensor(String words) {
		blockedWords = words.split(" ");
	}
	@Override
	public void deliverMessage(String message) {
		StringBuilder builder =  new StringBuilder();
		String[] myMessage = message.split(" ");
		for (String i : myMessage) {
			for (int j=0; j<blockedWords.length; j++) {
				if (i.equals(blockedWords[j])) {
					for (int k=0; k<blockedWords[j].length(); k++) {
						builder.append("#");
					}
					builder.append(" ");
				} else {
					builder.append(i + " ");
				}
			}
		}
		String temp = builder.toString();
		temp = temp.substring(0, temp.length() - 1);
		delegate.deliverMessage(temp);

	}
}
