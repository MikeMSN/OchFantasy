package mi.mo;

import com.google.common.base.Functions;
import com.google.common.collect.*;
import mi.mo.mbeans.Setting;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {


    public static void main(String[] args) {
        initMBeans();
        playgroundActionsWithGuavaCollections();

    }

    private static void initMBeans() {
        try {
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
            ObjectName name = new ObjectName("mi.mo:type=Setting");
            Setting mbean = Setting.getInstance();
            mbs.registerMBean(mbean, name);
            mbean.setControl(10);
        } catch (MalformedObjectNameException | NotCompliantMBeanException | MBeanRegistrationException | InstanceAlreadyExistsException e) {
            e.printStackTrace();
        }
    }

    private static void playgroundActionsWithGuavaCollections() {
        BiMap<String, Integer> words = HashBiMap.create();
        words.put("First", 1);
        words.put("Second", 2);
        words.put("Third", 3);
        System.out.println(words.toString());
        System.out.println(words.inverse().toString());

        Multimap<String, String> multimap = ArrayListMultimap.create();
        multimap.put("fruit", "apple");
        multimap.put("fruit", "banana");
        multimap.put("pet", "cat");
        multimap.put("pet", "dog");
        System.out.println(multimap.toString());
        System.out.println(multimap.get("pet"));
        System.out.println(multimap.values().toString());

        Table<String,String,Integer> distance = HashBasedTable.create();
        distance.put("London", "Paris", 340);
        distance.put("New York", "Los Angeles", 3940);
        distance.put("London", "New York", 5576);
        System.out.println(distance.toString());
        System.out.println(distance.cellSet());
    }

}
