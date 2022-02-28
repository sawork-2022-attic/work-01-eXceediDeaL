package stardustdl.saworks.asciipanel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import asciiPanel.AsciiFont;
import asciiPanel.AsciiPanel;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class AsciipanelApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AsciipanelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String name = "xml";
		if (args.length > 0) {
			name = args[0];
		}
		System.out.println("Using " + name + " context");

		AbstractApplicationContext context;
		switch (name) {
			case "java": {
				context = new AnnotationConfigApplicationContext(Config.class);
			}
				break;
			default: {
				context = new ClassPathXmlApplicationContext("config.xml");
			}
				break;
		}

		AsciiPanel panel = (AsciiPanel) context.getBean("panel");
		System.out.println("Panel Width in Characters: " + panel.getWidthInCharacters());
		System.out.println("Panel Height in Characters: " + panel.getHeightInCharacters());

		AsciiFont font = panel.getAsciiFont();
		System.out.println("Font File Name: " + font.getFontFilename());
		System.out.println("Font Width: " + font.getWidth());
		System.out.println("Font Height: " + font.getHeight());

		context.close();
	}
}
