package Data_Structure_Assignment;

import java.util.*;
public class Quetion1and2 {
    public static void main(String[] args) {
        General sunQuan = new General("Sun Quan", "Emperor", 96, 98, 72, 77, 95);
        TreeNode sunQuanNode = new TreeNode(sunQuan);

        General zhouYu = new General("Zhou Yu", "Cavalry", 80, 86, 97, 80, 90);
        TreeNode zhouYuNode = new TreeNode(zhouYu);

        General zhangZhao = new General("Zhang Zhao", "Archer", 22, 80, 89, 99, 60);
        TreeNode zhangZhaoNode = new TreeNode(zhangZhao);

        sunQuanNode.addChild(zhouYuNode);
        sunQuanNode.addChild(zhangZhaoNode);

        General xuSheng = new General("Xu Sheng", "Archer", 90, 78, 72, 40, 94);
        General zhuGeJin = new General("Zhu Ge Jin", "Archer", 63, 61, 88, 82, 71);
        General luSu = new General("Lu Su", "Infantry", 43, 87, 84, 88, 53);
        General taiShiCi = new General("Tai Shi Ci", "Cavalry", 96, 81, 43, 33, 97);
        General xiaoQiao = new General("Xiao Qiao", "Infantry", 42, 52, 89, 77, 34);
        General daQiao = new General("Da Qiao", "Cavalry", 39, 62, 90, 62, 41);
        General zhouTai = new General("Zhou Tai", "Infantry", 92, 89, 72, 43, 99);
        General ganNing = new General("Gan Ning", "Archer", 98, 92, 45, 23, 97);
        General luMeng = new General("Lu Meng", "Cavalry", 70, 77, 93, 83, 88);
        General huangGai = new General("Huang Gai", "Infantry", 83, 98, 72, 42, 89);

        ArrayList<General> general1s = new ArrayList<>();
        general1s.add(zhouYu);
        general1s.add(zhangZhao);
        general1s.add(xuSheng);
        general1s.add(zhuGeJin);
        general1s.add(luSu);
        general1s.add(taiShiCi);
        general1s.add(xiaoQiao);
        general1s.add(daQiao);
        general1s.add(zhouTai);
        general1s.add(ganNing);
        general1s.add(luMeng);
        general1s.add(huangGai);

        for (General general1 : general1s) {
            TreeNode generalNode = new TreeNode(general1);
//            System.out.println(general.getAbilitySum() + " " + general.getName());
            if (general1.getIntelligence() > general1.getStrength()) {
                zhangZhaoNode.addChild(generalNode);
            } else {
                zhouYuNode.addChild(generalNode);
            }
        }
        sunQuanNode.displayTree();
        System.out.println();

        Comparator<General> abilityComparator = Comparator.comparingInt(General::getAbilitySum);
        Collections.sort(general1s, abilityComparator);
        
// binary search saja saja
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter specific sum of ability: ");
        int targetAbility = sc.nextInt();
        int index = binarySearch(general1s, targetAbility);
        if (index != -1) {
            General targetGeneral1 = general1s.get(index);
            System.out.println("General found with ability " + targetAbility + ": " + targetGeneral1.getName());
        } else {
            System.out.println("General not found with ability " + targetAbility);
        }


        Comparator<General> politicComparator = Comparator.comparingInt(General::getPolitics).reversed();
        Comparator<General> leadershipComparator = Comparator.comparingInt(General::getLeadership).reversed();
        Comparator<General> strengthComparator = Comparator.comparingInt(General::getStrength).reversed();
        Comparator<General> intelligenceComparator = Comparator.comparingInt(General::getIntelligence).reversed();

        Collections.sort(general1s, politicComparator);
        List<General> politicTeam = formTeam(general1s, "politic", 3);

        Set<General> selectedGeneral1s = new HashSet<>(politicTeam);

        Collections.sort(general1s, leadershipComparator);
        List<General> leadershipTeam = formTeam(general1s, "leadership", 3, selectedGeneral1s);

        selectedGeneral1s.addAll(leadershipTeam);

        Collections.sort(general1s, strengthComparator);
        List<General> strengthTeam = formTeam(general1s, "strength", 3, selectedGeneral1s);

        selectedGeneral1s.addAll(strengthTeam);

        Collections.sort(general1s, intelligenceComparator);
        List<General> intelligenceTeam = formTeam(general1s, "intelligence", 3, selectedGeneral1s);

        System.out.println("Politic Team:");
        displayTeam(politicTeam);

        System.out.println("\nLeadership Team:");
        displayTeam(leadershipTeam);

        System.out.println("\nStrength Team:");
        displayTeam(strengthTeam);

        System.out.println("\nIntelligence Team:");
        displayTeam(intelligenceTeam);

    }
//untuk no 4th param
    private static List<General> formTeam(List<General> general1s, String field, int count) {
        List<General> team = new ArrayList<>();
        int remainingCount = count;

        for (General general1 : general1s) {
            if (remainingCount == 0) {
                break;
            }

            if (isPositiveStat(general1, field)) {
                team.add(general1);
                remainingCount--;
            }
        }

        return team;
    }
// for excluding the same repeating generals
    private static List<General> formTeam(List<General> general1s, String field, int count, Set<General> excludedGeneral1s) {
        List<General> team = new ArrayList<>();
        int remainingCount = count;

        for (General general1 : general1s) {
            if (remainingCount == 0) {
                break;
            }

            if (!excludedGeneral1s.contains(general1) && isPositiveStat(general1, field)) {
                team.add(general1);
                excludedGeneral1s.add(general1);
                remainingCount--;
            }
        }

        return team;
    }
    private static boolean isPositiveStat(General general1, String field) {
        int stat;
        switch (field) {
            case "politic":
                stat = general1.getPolitics();
                break;
            case "leadership":
                stat = general1.getLeadership();
                break;
            case "strength":
                stat = general1.getStrength();
                break;
            case "intelligence":
                stat = general1.getIntelligence();
                break;
            default:
                return false;
        }
        return stat >= 0;
    }

    private static void displayTeam(List<General> team) {
        for (General general1 : team) {
            System.out.println("Name: " + general1.getName() +
                    ", Politic: " + general1.getPolitics() +
                    ", Leadership: " + general1.getLeadership() +
                    ", Strength: " + general1.getStrength() +
                    ", Intelligence: " + general1.getIntelligence() +
                    ", Ability Sum: " + general1.getAbilitySum());
        }
    }

    private static int binarySearch(List<General> general1s, int targetAbility) {
        int left = 0;
        int right = general1s.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int ability = general1s.get(mid).getAbilitySum();

            if (ability == targetAbility) {
                return mid;
            } else if (ability < targetAbility) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -(left + 1);
    }


}
