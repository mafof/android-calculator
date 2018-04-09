package calculator.mafof.com.calculator;

import android.util.Log;

public class MyLog {

    private static boolean isLog = true;
    private static final String TAG = "DEB";

    public static boolean getLog() {
        return isLog;
    }

    /**
     * Метод включающий или отключающий логирование(по дефолту логи включены)
     */
    public static void setLog(boolean isLog) {
        MyLog.isLog = isLog;
    }

    /**
     * Метод аналог log.d
     * @param str - Строка сообщения
     */
    public static void d(String str) {
        if(getLog()) Log.d(TAG, str);
    }

    public static void d(Number str) {
        if(getLog()) Log.d(TAG, String.valueOf(str));
    }

    public static void d(Boolean str) {
        if(getLog()) Log.d(TAG, String.valueOf(str));
    }

    /**
     * Метод аналог log.i
     * @param str - Строка сообщения
     */
    public static void e(String str) {
        if(getLog()) Log.e(TAG, str);
    }
}

