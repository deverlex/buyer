package vn.needy.buyer.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import static vn.needy.buyer.utils.Constant.NUMBER_COMPRESS;

/**
 * Created by lion on 16/12/2017.
 */

public class Utils {

    public static class PhoneNumberUtils {
        public static boolean isValidPhoneNumber(String phoneNumber) {
            PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
            try {
                Phonenumber.PhoneNumber pNumber = phoneNumberUtil.parse(phoneNumber, "VN");
                PhoneNumberUtil.PhoneNumberType phoneNumberType = phoneNumberUtil.getNumberType(pNumber);
                return phoneNumberType == PhoneNumberUtil.PhoneNumberType.MOBILE;
            } catch (final Exception e) {
            }
            return false;
        }

        public static String formatPhoneNumber(String phoneNumber) {
            PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
            try {
                Phonenumber.PhoneNumber swissNumberProto = phoneNumberUtil.parse(phoneNumber, "VN");
                phoneNumber = phoneNumberUtil.format(swissNumberProto, PhoneNumberUtil.PhoneNumberFormat.E164);
                return phoneNumber.replaceAll("\\s+", "");
            } catch (NumberParseException e) {
            }
            return phoneNumber;
        }
    }

    public static class DateTimeUtils {

    }

    public static class ImageUtils {
        public static String convertImageToBase64(InputStream imageStream) {
            final Bitmap image = BitmapFactory.decodeStream(imageStream);
            String encodedImage = encodeImage(image);
            return encodedImage;
        }

        private static String encodeImage(Bitmap bm) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bm.compress(Bitmap.CompressFormat.JPEG, NUMBER_COMPRESS, baos);
            byte[] b = baos.toByteArray();
            return Base64.encodeToString(b, Base64.DEFAULT);
        }
    }
}
