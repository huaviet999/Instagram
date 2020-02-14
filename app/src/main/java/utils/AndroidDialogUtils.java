package utils;

//Singleton Pattern

import android.app.ProgressDialog;
import android.content.Context;

import com.example.instagram.R;
import com.ontbee.legacyforks.cn.pedant.SweetAlert.SweetAlertDialog;


/**
 * Created by Viet Hua on 2/14/2020
 */
public class AndroidDialogUtils {

    private AndroidDialogUtils() {
    }

    private static AndroidDialogUtils INSTANCE;

    public static AndroidDialogUtils getInstance() {
        AndroidDialogUtils localInstance;
        if (INSTANCE == null) {
            synchronized (AndroidDialogUtils.class) {
                if (INSTANCE == null) {
                    localInstance = new AndroidDialogUtils();
                    INSTANCE = localInstance;
                }
            }
        }
        return INSTANCE;
    }

    /**
     * SHOW/HIDE SWEET DIALOG
     */
    private SweetAlertDialog sweetAlertDialog;

    public void hideSweetAlertDialog() {
        if (sweetAlertDialog != null) {
            sweetAlertDialog.dismiss();
        }
        sweetAlertDialog = null;
    }

    public void showSuccessSweetAlertDialog(Context context, String message) {
        hideSweetAlertDialog();
        sweetAlertDialog = new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE);
        sweetAlertDialog
                .setTitleText(context.getString(R.string.success))
                .setCustomImage(null)
                .setContentText(message).show();
    }

    public void showErrorSweetAlertDialog(Context context, String message) {
        hideSweetAlertDialog();
        sweetAlertDialog = new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE);
        sweetAlertDialog.setTitleText(context.getString(R.string.error))
                .setCustomImage(null)
                .setContentText(message).show();
    }

    public void showLoadingSweetAlertDialog(Context context, String message) {
        hideSweetAlertDialog();
        sweetAlertDialog = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE);
        sweetAlertDialog.setTitleText(context.getString(R.string.loading))
                .setCustomImage(null)
                .setContentText(message).show();
    }

    public void showWarningSweetAlertDialog(Context context, String message) {
        hideSweetAlertDialog();
        sweetAlertDialog = new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE);
        sweetAlertDialog.setTitleText(context.getString(R.string.warning))
                .setCustomImage(null)
                .setContentText(message).show();
    }

    /**
     * SHOW/HIDE PROGRESS DIALOG
     */
    private ProgressDialog mProgressDialog;

    public void hideProgressDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
        mProgressDialog = null;
    }

    public void showProgressDialog(Context context, String message) {
        hideProgressDialog();
        mProgressDialog = ProgressDialog.show(context, null, message, false, false, null);
    }
}
