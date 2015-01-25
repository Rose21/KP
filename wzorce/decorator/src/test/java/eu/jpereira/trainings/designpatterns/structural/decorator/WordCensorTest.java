package eu.jpereira.trainings.designpatterns.structural.decorator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannel;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannelBuilder;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannelProperties;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannelPropertyKey;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.decorator.AbstractSocialChanneldDecoratorTest;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.decorator.MessageTruncator;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.spy.TestSpySocialChannel;

public class WordCensorTest extends AbstractSocialChanneldDecoratorTest {
	@Test
	public void testTruncate() {
		// Create the builder
		SocialChannelBuilder builder = createTestSpySocialChannelBuilder();

		// create a spy social channel
		SocialChannelProperties props = new SocialChannelProperties().putProperty(SocialChannelPropertyKey.NAME, TestSpySocialChannel.NAME);
		SocialChannel channel = builder.with(new WordCensor("polityk")).getDecoratedChannel(props);

		// Now call channel.deliverMessage
		channel.deliverMessage("polityk polityka same klamstwa is a message");
		
		// Spy channel. Should get the one created before
		TestSpySocialChannel spyChannel = (TestSpySocialChannel) builder.buildChannel(props);
		assertEquals("####### polityka same klamstwa is a message", spyChannel.lastMessagePublished());	
	}
}
