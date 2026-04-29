package com.example.job.B0000.B0005;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.entity.T01Oya;

import jp.co.golorp.emarf.exception.SysError;
import jp.co.golorp.emarf.job.BaseJob;

/**
 * CSVファイルの入力
 *
 * @author toshiyuki
 *
 */
public class B0005Job extends BaseJob {

    /**
     * logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(B0005Job.class);

    /**
     * エントリポイント
     *
     * @param args
     */
    public static void main(final String[] args) {
        new B0005Job().run(args);
    }

    /**
     * 主処理
     *
     * @param now
     * @param jobId
     * @param args
     */
    public void running(final LocalDateTime now, final String jobId, final String[] args) {

        String filePath = "out/output_fixed.csv";

        boolean isTitle = true;
        String[] titles = null;

        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {

            String line;
            while ((line = br.readLine()) != null) {

                if (isTitle) {
                    isTitle = false;
                    if (line.split("\",\"").length > 1) {
                        titles = line.split("\",\"");
                    } else if (line.split("\t").length > 1) {
                        titles = line.split("\t");
                    } else {
                        titles = line.split(",");
                    }
                    continue;
                }

                String[] values = null;
                if (line.split("\",\"").length > 1) {
                    values = line.split("\",\"");
                } else if (line.split("\t").length > 1) {
                    values = line.split("\t");
                } else {
                    values = line.split(",");
                }

                T01Oya t01Oya = null;

                if (titles.length > 0) {
                    Map<String, Object> map = new HashMap<>();
                    for (int i = 0; i < titles.length; i++) {
                        map.put(titles[i], values[i]);
                    }
                    t01Oya = new T01Oya(map);
                } else {
                    t01Oya = new T01Oya(values);
                }

                try {
                    t01Oya.insert(now, jobId);
                } catch (Exception e) {
                    LOG.error("CSVファイルの入力に失敗", e);
                    Files.write(
                            Paths.get(filePath + ".err"),
                            Collections.singletonList(line),
                            StandardOpenOption.CREATE,
                            StandardOpenOption.APPEND);
                }
            }

        } catch (IOException e) {
            throw new SysError(e);
        }
    }

}
