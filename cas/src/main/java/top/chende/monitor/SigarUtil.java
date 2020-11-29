package top.chende.monitor;

import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.OperatingSystem;
import org.hyperic.sigar.Sigar;

public class SigarUtil {
    private static  Runtime r = Runtime.getRuntime();
    private static  Sigar sigar = new Sigar();
    private static   OperatingSystem OS = OperatingSystem.getInstance();

    public static void main(String[] args) throws Exception{
        CpuInfo infos[] = sigar.getCpuInfoList();

        CpuPerc cpuList[] = null;
        cpuList = sigar.getCpuPercList();
        double sys = 0;
        double wait = 0;
        double idle = 0;
        for (int i = 0; i < infos.length; i++) {// 不管是单块CPU还是多CPU都适用
            CpuInfo info = infos[i];
            System.out.println("第" + (i + 1) + "块CPU信息");
            System.out.println("CPU的总量MHz:    " + info.getMhz());// CPU的总量MHz
            System.out.println("CPU生产商:    " + info.getVendor());// 获得CPU的卖主，如：Intel
            System.out.println("CPU类别:    " + info.getModel());// 获得CPU的类别，如：Celeron
            System.out.println("CPU缓存数量:    " + info.getCacheSize());// 缓冲存储器数量
//            sys+=Double.valueOf(FormatUtil.delChar(CpuPerc.format(cpuList[i].getCombined())));
//            wait+=Double.valueOf(FormatUtil.delChar(CpuPerc.format(cpuList[i].getWait())));
//            idle+=Double.valueOf(FormatUtil.delChar(CpuPerc.format(cpuList[i].getIdle())));
        }
    }
}
