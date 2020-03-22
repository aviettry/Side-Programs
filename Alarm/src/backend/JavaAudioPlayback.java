
/**
 * 
 */
package backend;

import java.io.File; 
import org.apache.commons.io.FileUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

/**
 * @author aviettry
 *
 */
public class JavaAudioPlayback {

	private Clip recording; //Closed
	private AudioInputStream ais; //Closed
	private File audioFile;
	private static String audioFileLocation = "/posture.wav";

	public JavaAudioPlayback() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
		LoadAudioFile();
		audioFile = new File("./posture.wav");
		InitializeClip();
	}
	
	private static void LoadAudioFile() throws IOException {
		InputStream is = JavaAudioPlayback.class
				.getResourceAsStream(audioFileLocation);
		File file = new File("."+audioFileLocation);
		FileUtils.copyInputStreamToFile(is, file);
		is.close();
	}
	
	private void InitializeClip() throws LineUnavailableException, UnsupportedAudioFileException, IOException {
		recording = AudioSystem.getClip();
		ais = AudioSystem.getAudioInputStream(audioFile);
		recording.open(ais);
		recording.loop(0);
		recording.addLineListener(new LineListener() {
			
			@Override
			public void update(LineEvent event) {
				if(event.getType().equals(LineEvent.Type.STOP)) {
					recording.setMicrosecondPosition(0);
				}
			}
		});
	}
	
	public void Run() {
		recording.start();
	}
	
	public void Close() throws IOException {
		recording.stop();
		recording.close();
		ais.close();
	}
	
	/**
	 * @param args
	 * @throws UnsupportedAudioFileException 
	 * @throws LineUnavailableException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, LineUnavailableException, UnsupportedAudioFileException {

		JavaAudioPlayback player = new JavaAudioPlayback();
		

		ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(1);
		ScheduledFuture<?> schedule = scheduler.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				player.Run();
			}
		}, 0, 10, TimeUnit.MINUTES);
		
		JOptionPane.showMessageDialog(null, "Close to end program.");
		schedule.cancel(true);
		player.Close();
		System.exit(0);
	}

}
