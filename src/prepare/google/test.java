package prepare.google;

import prepare.common.DisplayUtils;

import java.util.*;

public class test {

	public static void main(String[] args) {
		String[] skills = {"algorithms","prepare.math","java","reactjs","csharp","aws"};
//		[["algorithms","prepare.math","java"],["algorithms","prepare.math","reactjs"],["java","csharp","aws"],["reactjs","csharp"],["csharp","prepare.math"],["aws","java"]]
		List<List<String>> people = new ArrayList<>();
		people.add(new ArrayList<String>());
		people.get(0).add("algorithms");
		people.get(0).add("prepare.math");
		people.get(0).add("java");

		people.add(new ArrayList<String>());
		people.get(1).add("algorithms");
		people.get(1).add("prepare.math");
		people.get(1).add("reactjs");

		people.add(new ArrayList<String>());
		people.get(2).add("java");
		people.get(2).add("csharp");
		people.get(2).add("aws");

		people.add(new ArrayList<String>());
		people.get(3).add("reactjs");
		people.get(3).add("csharp");

		people.add(new ArrayList<String>());
		people.get(4).add("csharp");
		people.get(4).add("prepare.math");

		people.add(new ArrayList<String>());
		people.get(5).add("aws");
		people.get(5).add("java");
		int arr[] = smallestSufficientTeam(skills, people);
		System.out.println("Result: ");
		DisplayUtils.array(arr);
	}

	static List<Integer> resultSet = new ArrayList();
	public static int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
		Set<String> skillsSet = new HashSet<>(Arrays.asList(req_skills));
		smallestSufficientTeam(skillsSet, people, 0, new HashMap<String, Integer>(), new ArrayList<Integer>());
		return resultSet.stream().mapToInt(Integer::intValue).toArray();
	}

	private static List<Integer> smallestSufficientTeam(Set<String> skillsSet, List<List<String>> peopleSkills, int index, Map<String, Integer> skillSubset, List<Integer> peoples) {
		System.out.println("Skill set: " + skillsSet);
		System.out.println("Skill subset: " + skillSubset);
		System.out.println("Result subset: " + resultSet);
		System.out.println("People: " + peoples);
		System.out.println("-----------");
		if(skillsSet.size()==skillSubset.size() && (resultSet.size()==0 || resultSet.size()>peoples.size())) {
			resultSet = new ArrayList<Integer>(peoples);
			return resultSet;
		} else if(index==peopleSkills.size())
			return resultSet;


		smallestSufficientTeam(skillsSet, peopleSkills, index+1, skillSubset, peoples);

		Set<String> subset = new HashSet();
		for(String skill: peopleSkills.get(index)){
			if(skillsSet.contains(skill))
				subset.add(skill);
		}

		for(String skill: subset)
			skillSubset.put(skill, skillSubset.getOrDefault(skill, 0)+1);

		peoples.add(index);
		smallestSufficientTeam(skillsSet, peopleSkills, index+1, skillSubset, peoples);
		peoples.remove(peoples.size()-1);
		for(String skill: subset) {
			skillSubset.put(skill, skillSubset.get(skill) - 1);
			if(skillSubset.get(skill)==0)
				skillSubset.remove(skill);
		}
		return resultSet;
	}
}


