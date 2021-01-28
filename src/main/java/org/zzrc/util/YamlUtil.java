package org.zzrc.util;

import com.alibaba.fastjson.JSONObject;
import org.yaml.snakeyaml.Yaml;
import org.zzrc.log.Log;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

public class YamlUtil {
	//yaml文件路径
	public String yamlPath;
	//初始化yaml路径
	public YamlUtil(String yamlPath) {
		this.yamlPath = yamlPath;
	}
	/**
	 * PS:获取yaml数据
	 * @return
	 */
	public Map<String,Map> getYamlData() {
		File file = new File(yamlPath);
		Yaml yaml = new Yaml();
		Map<String,Map> map = null;
		try {
			map = yaml.loadAs(new FileInputStream(file), Map.class);
		} catch (FileNotFoundException e) {
			Log.error("["+yamlPath+"]yaml文件读取异常");
		}
		return map;
	}
	public static void main(String[] args) {
		YamlUtil util = new YamlUtil("src/main/resources/yaml/peony.yaml");
		Map<String,Map> map = util.getYamlData();
		Map<String,String> map1 = map.get("case001");
		System.out.println(map1.get("url"));
	}
}
