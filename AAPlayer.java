public class AAPlayer implements MP3,WAV,OGG {
    public AAPlayer() {
    }

    public void info1(){
        System.out.println("插件mp3调用");
    }
    public void info2(){
        System.out.println("插件wav调用");
    }
    public void info3(){
        System.out.println("插件ogg调用");
    }

    @Override
    public void loadFile(String filename) {
        System.out.println("加载文件"+filename);
    }

    @Override
    public void play() {
        System.out.println("播放音乐");
    }

    @Override
    public void stop() {
        System.out.println("停止播放音乐");
    }

    @Override
    public void pause() {
        System.out.println("暂停音乐");
    }
}
