package e.johncarlos.languageinapp;

import android.app.Application;
import android.content.Context;

public class Home extends Application {
        @Override
        protected void attachBaseContext(Context base) {
            super.attachBaseContext(LocalHelper.onAttach(base, "en"));
        }
}
