import android.util.Log;

public class ELog {
	// when online set this value to false
	public static boolean debugeMode = true;
	// you can set this TAG
	// notice that if you change it , all log will change to the tag you seted
	public static String TAG = "MYLOG";

	private ELog() {
	}

	private static String getString(Object object) {
		StackTraceElement ste = new Throwable().getStackTrace()[2];
		String valueString = ste.getFileName().split("\\.")[0] + "  "
				+ ste.getMethodName() + ":" + ste.getLineNumber() + "\n"
				+ object.toString();
		return valueString;
	}

	public static void e(Object object) {
		if (debugeMode) {
			Log.e(TAG, getString(object));
		}
	}

	public static void i(Object object) {
		if (debugeMode) {
			Log.i(TAG, getString(object));
		}
	}

	public static void d(Object object) {
		if (debugeMode) {
			Log.d(TAG, getString(object));
		}
	}
}