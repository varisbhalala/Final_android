

package com.dmsl.anyplace.utils;

import java.io.File;

import android.content.Context;

public class AnyplaceUtils {

	public static File getFolderRootFolder(Context ctx, String folder) throws Exception {
		if (!AndroidUtils.checkExternalStorageState()) {
			throw new Exception("Error: It seems that we cannot write on your sdcard!");
		}

		File sdcard_root = ctx.getExternalFilesDir(null);
		if (sdcard_root == null) {
			throw new Exception("Error: It seems we cannot access the sdcard!");
		}
		File root = new File(sdcard_root, folder);
		root.mkdirs();
		if (root.isDirectory() == false) {
			throw new Exception("Error: It seems we cannot write on the sdcard!");
		}
		return root;
	}

	/**
	 * Returns the File to the root folder where floor plans are stored on the
	 * device external memory
	 * 
	 * @return
	 * @throws Exception
	 */
	public static File getFloorPlansRootFolder(Context ctx) throws Exception {
		return getFolderRootFolder(ctx, "floor_plans");
	}

	/**
	 * Returns the File to the root folder where radio maps are stored on the
	 * device external memory
	 * 
	 * @return
	 * @throws Exception
	 */
	public static File getRadioMapsRootFolder(Context ctx) throws Exception {
		return getFolderRootFolder(ctx, "radiomaps");
	}

	/**
	 * Returns the filename for the radiomap to be used according to the floor
	 * selected
	 * 
	 * @return
	 */
	public static String getRadioMapFileName(String floor) {
		return "fl_" + (floor == null ? "-" : floor) + "_indoor-radiomap.txt";
	}

	public static File getRadioMapFoler(Context ctx, String buid, String floor) throws Exception {
		File root = getRadioMapsRootFolder(ctx);
		File file = new File(root, (buid == null ? "-" : buid) + "fl_" + (floor == null ? "-" : floor));
		file.mkdirs();

		if (file.isDirectory() == false) {
			throw new Exception("Error: It seems we cannot write on the sdcard!");
		}

		return file;
	}

}
