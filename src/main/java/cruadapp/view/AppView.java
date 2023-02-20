package cruadapp.view;

public class AppView {
    SkillView skillView = new SkillView();
    SpecialtyView specialtyView = new SpecialtyView();
    DeveloperView developerView = new DeveloperView();
    public void mainWorkProgram(){
        developerView.workProgram();
        skillView.workProgram();
        specialtyView.workProgram();
    }

    public static AppView appView;

    private AppView(){}

    public static AppView getAppView(){
        if (appView == null){
            appView = new AppView();
        }
        return appView;
    }
}
