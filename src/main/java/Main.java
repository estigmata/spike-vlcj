import uk.co.caprica.vlcj.component.EmbeddedMediaListPlayerComponent;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;

import javax.swing.*;
import java.nio.file.Paths;

public class Main {
  private JFrame frame;
  private EmbeddedMediaListPlayerComponent mediaPlayerComponent;

  public static void main(String[] args) {
    new NativeDiscovery().discover();
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new Main();
      }
    });
  }

  public Main() {
    frame = new JFrame("My First Media Player");
    frame.setBounds(100, 100, 600, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mediaPlayerComponent = new EmbeddedMediaListPlayerComponent();
    frame.setContentPane(mediaPlayerComponent);
    frame.setVisible(true);
    mediaPlayerComponent.getMediaPlayer().playMedia(Paths.get("C:\\Videos\\Test.mp4").toUri().toString());
  }
}
