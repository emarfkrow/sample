package com.example.form;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import jp.co.golorp.emarf.form.base.LoginFormBase;

/**
 * ログインフォーム
 */
public class LoginForm extends LoginFormBase {

    @Override
    public final Map<String, Integer> getTableAuthZ(final String tableName) {

        Map<String, Integer> tableAuthZ = new HashMap<String, Integer>();

        for (Entry<String, Integer> e : this.getAuthzInfo().entrySet()) {
            String tableRegex = e.getKey();
            Integer kengenBF = e.getValue();

            if (tableName.matches(tableRegex)) {
                if ((kengenBF & 0b00000001) != 0) {
                    tableAuthZ.put("view", 1); // 第１ビット：照会権限：1
                }
                if ((kengenBF & 0b00000010) != 0) {
                    tableAuthZ.put("seek", 1); // 第２ビット：検索権限：2
                }
                if ((kengenBF & 0b00000100) != 0) {
                    tableAuthZ.put("output", 1); // 第３ビット：出力権限：4
                }
                if ((kengenBF & 0b00001000) != 0) {
                    tableAuthZ.put("anew", 1); // 第４ビット：追加権限：8
                }
                if ((kengenBF & 0b00010000) != 0) {
                    tableAuthZ.put("edit", 1); // 第５ビット：更新権限：16
                }
                if ((kengenBF & 0b00100000) != 0) {
                    tableAuthZ.put("delete", 1); // 第６ビット：削除権限：32
                }
                if ((kengenBF & 0b01000000) != 0) {
                    tableAuthZ.put("permit", 1); // 第７ビット：承認権限：64
                }
                if ((kengenBF & 0b10000000) != 0) {
                    tableAuthZ.put("forbid", 1); // 第８ビット：否認権限：128
                }
            }
        }

        return tableAuthZ;
    }

}
