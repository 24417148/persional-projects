package com.zyl.cases;

import com.zyl.cases.enums.SingletonEnum;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Demo {

  private void sss() {
    List<String> l1 = new ArrayList<String>();
    List<String> l2 = new LinkedList<>();
    Set<String> s1 = new HashSet<>();
    Map<String, String> m1 = new HashMap<>();
    Map<String, String> m2 = new Hashtable<>();
    Map<String, String> m3 = new LinkedHashMap<>();
    Map<String, String> m4 = new Hashtable<>();

    File file = new File("");
  }

}
