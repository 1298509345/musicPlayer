import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class AAPFrame extends JFrame {
    public JButton button_mp3;
    public JButton button_wav;
    public JButton button_ogg;
    public JButton chooseFile;

    public AAPFrame() {
        setTitle("播放器");
        setBounds(100, 100, 400, 250);
        // 实例化FlowLayout流式布局类的对象，指定对齐方式为居中对齐，组件之间的间隔为5个像素
        FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 10, 10);
        // 实例化流式布局类的对象
        setLayout(fl);
        init();
        setVisible(true);//放在添加组件后面执行
    }

    public void init() {
        AAPlayer p = new AAPlayer();
        button_mp3 = new JButton("上一曲");
        Dimension dim = new Dimension(150, 30);
        button_mp3.setSize(dim);
        button_mp3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        add(button_mp3);
        button_wav = new JButton("暂停");
        button_wav.setSize(dim);
        button_wav.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(button_wav);

        button_ogg = new JButton("下一曲");
        button_ogg.setSize(dim);
        button_ogg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(button_ogg);

        chooseFile = new JButton("选择文件");
        chooseFile.setSize(dim);
        chooseFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int i = fileChooser.showOpenDialog(getContentPane());// 显示文件选择对话框

                // 判断用户单击的是否为“打开”按钮
                if (i == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();// 获得选中的文件对象
                    chooseFile.setText(selectedFile.getName());// 显示选中文件的名称
                    String suffix=selectedFile.getName().substring(selectedFile.getName().length()-3);
                    if(suffix.equals("mp3")){
                        MP3 mp3 = p;
                        mp3.info1();
                        mp3.loadFile("音乐a");
                        mp3.play();
                        mp3.stop();
                    }
                    else if(suffix.equals("wav")){
                        WAV wav = p;
                        wav.info2();
                        wav.loadFile("音乐b");
                        wav.play();
                        wav.stop();
                    }
                    else{
                        OGG ogg = p;
                        ogg.info3();
                        ogg.loadFile("音乐c");
                        ogg.play();
                        ogg.stop();
                    }
                }
            }
        });
        add(chooseFile);
    }

    public static void main(String[] args) {
        AAPFrame frame = new AAPFrame();
    }
}
