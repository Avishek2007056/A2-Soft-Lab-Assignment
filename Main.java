// 2007056
// Design Pattern Bridge



interface TV {
    boolean isEnabled();

    void enable();

    void disable();

    int getVolume();

    void setVolume(int volume);

    int getChannel();

    void setChannel(int channel);
}

class GeneralTv implements TV {
    boolean powerOn = false;
    int volume = 0;
    int channel = 0;

    public boolean isEnabled() {
        return powerOn;
    }

    public void enable() {
        powerOn = true;
    }

    public void disable() {
        powerOn = false;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

}

class SmartTv implements TV {

    boolean powerOn = false;
    int volume = 0;
    int channel = 0;

    public boolean isEnabled() {
        return powerOn;
    }

    public void enable() {
        powerOn = true;
    }

    public void disable() {
        powerOn = false;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public void YouTube() {
        System.out.println("Inside Youtube");
    }
}

class Remote {
    public TV tv;

    public Remote(TV tv) {
        this.tv = tv;
    }

    public void togglePower() {
        if (tv.isEnabled()) {
            tv.disable();
            System.out.println("The state of TV: " + (tv.isEnabled()));
        } else {
            tv.enable();
            System.out.println("The state of TV: " + (tv.isEnabled()));
        }
    }

    public void volumeUp() {
        tv.setVolume(Math.min(100, (tv.getVolume() + 1)));
        System.out.println("volume condition " + (tv.getVolume()));
    }

    public void volumeDown() {
        tv.setVolume(Math.max(0, (tv.getVolume() - 1)));
        System.out.println("volume condition " + (tv.getVolume()));
    }

    public void channelUp() {
        tv.setChannel(Math.min(100, (tv.getChannel() + 1)));
        System.out.println("Channel condition " + (tv.getChannel()));
    }

    public void channelDown() {
        tv.setChannel(Math.max(0, (tv.getChannel() - 1)));
        System.out.println("Channel condition " + (tv.getChannel()));
    }
}

class SmartRemote extends Remote {
    public SmartRemote(TV tv) {
        super(tv);
    }

    public void showYoutube() {
        if (tv instanceof SmartTv) {
            ((SmartTv) tv).YouTube();
        } else {
            System.out.println("Youtube Invalid");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        GeneralTv generalTv = new GeneralTv();
        SmartTv smartTv = new SmartTv();
        Remote remoteForGeneralTv = new Remote(generalTv);
        Remote remoteForSmartTv = new Remote(smartTv);
        SmartRemote smartRemoteForSmartTv = new SmartRemote(smartTv);
        SmartRemote smartRemoteForGeneralTv = new SmartRemote(generalTv);
        remoteForGeneralTv.togglePower();
        remoteForGeneralTv.channelUp();
        remoteForGeneralTv.channelDown();
        remoteForGeneralTv.volumeUp();
        remoteForGeneralTv.volumeDown();
        remoteForGeneralTv.togglePower();

        System.out.println();
        remoteForSmartTv.togglePower();
        remoteForSmartTv.channelUp();
        remoteForSmartTv.channelDown();
        remoteForSmartTv.volumeUp();
        remoteForSmartTv.volumeDown();
        remoteForSmartTv.togglePower();

        System.out.println();
        smartRemoteForGeneralTv.togglePower();
        smartRemoteForGeneralTv.channelUp();
        smartRemoteForGeneralTv.channelDown();
        smartRemoteForGeneralTv.volumeUp();
        smartRemoteForGeneralTv.volumeDown();
        smartRemoteForGeneralTv.showYoutube();
        smartRemoteForGeneralTv.togglePower();

        System.out.println();
        smartRemoteForSmartTv.togglePower();
        smartRemoteForSmartTv.channelUp();
        smartRemoteForSmartTv.channelDown();
        smartRemoteForSmartTv.volumeUp();
        smartRemoteForSmartTv.volumeDown();
        smartRemoteForSmartTv.showYoutube();
        smartRemoteForSmartTv.togglePower();
    }

}