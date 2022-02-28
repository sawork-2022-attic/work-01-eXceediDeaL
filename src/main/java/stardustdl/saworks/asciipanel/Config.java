package stardustdl.saworks.asciipanel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import asciiPanel.AsciiFont;
import asciiPanel.AsciiPanel;

@Configuration
public class Config {
    @Bean
    public AsciiPanel panel() {
        return new AsciiPanel(100, 50, font());
    }

    @Bean
    public AsciiFont font() {
        return AsciiFont.CP437_9x16;
    }
}
