package wx.realware.grp.pt.pb.common.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 
 * lfq
 *
 */
public class CollectionUtils  implements Serializable{

	public static boolean isListEmpty(List<?> list){
		if(list == null){
			return true;
		}
		return list.size() == 0;
	}
	public static boolean isMapEmpty(Map<?,?> map){
		if(map == null){
			return true;
		}
		return map.size() == 0;
	}
	
    public static boolean isEmpty(Collection<?> collection) {

		return (collection == null || collection.isEmpty());
    }
    
    public static boolean isEmpty(Map<?,?> map) {

		return (map == null || map.isEmpty());
    }
	
	/**
	 * 比较两个list是否相等，如果不等，且源list长度大于目标list则把源list中存在目标list中不存在的赋值给源list
	 * 把源list复制到目标list
	 */
	public static List copyList(List source, List goal) {
		if (source.size() < goal.size()) {
			return null;
		}
		boolean is_exist = false;
		for (int i = 0; i < source.size(); i++) {
			Object s = source.get(i);
			for (int j = 0; j < goal.size(); j++) {
				if (s.equals(goal.get(j))) {
					is_exist = true;
					break;
				}
			}
			if (!is_exist) {
				int len = goal.size();
				goal.set(len++, s);
			}
		}
		return goal;
	}
	
	/**
	 * 对数组逆向排序
	 * @param arraySource
	 * @return
	 */
	public static String[] backSortArray(String[] arraySource) {
		
		String [] backTcodes = new String [arraySource.length];
		int h=0;
		for(int i=arraySource.length-1; i>=0; i--) {
			backTcodes[h] = arraySource[i];
			h++;
		}
		
		return backTcodes;
	}
	

}
