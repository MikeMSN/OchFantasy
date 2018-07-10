package mi.mo.mbeans;

public class Setting implements SettingMBean {
    private static Setting ourInstance = new Setting();

    private int control;

    public static Setting getInstance() {
        return ourInstance;
    }

    private Setting() {
    }

    @Override
    public int getControl() {
        return this.getControl();
    }

    @Override
    public void setControl(int control) {
        this.control = control;
    }
}
