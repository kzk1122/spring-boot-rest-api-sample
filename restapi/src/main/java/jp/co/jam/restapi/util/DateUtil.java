package jp.co.jam.restapi.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    // yyyy/MM/ddの日付をDate型に変換する
    public static Date convertStringToDate(String dateStr) throws ParseException {
        // SimpleDateFormatを作成し、日付文字列を解析してDateオブジェクトに変換
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

        return formatter.parse(dateStr);
    }

    // 日付をyyyy/MM/dd形式に変換する
    public static String formatDate(Date date) {
        // フォーマッタを作成
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

        // Dateをフォーマットされた文字列に変換
        return formatter.format(date);
    }
}
