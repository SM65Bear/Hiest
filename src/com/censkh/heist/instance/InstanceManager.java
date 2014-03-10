package com.censkh.heist.instance;

import java.util.ArrayList;
import java.util.List;

public class InstanceManager {

	private static InstanceManager instance;
	private final List<Instance> instances = new ArrayList<Instance>();

	public InstanceManager() {
		instance = this;
		add(new Instance("Greenhead Bank"));
	}

	private void add(Instance instance) {
		instances.add(instance);
	}

	public static InstanceManager getInstance() {
		return instance;
	}

	public List<Instance> getInstances() {
		return instances;
	}

	public Instance getInstanceById(int i) {
		for (Instance inst : getInstances()) {
			if (inst.getId() == i) {
				return inst;
			}
		}
		return null;
	}

}
