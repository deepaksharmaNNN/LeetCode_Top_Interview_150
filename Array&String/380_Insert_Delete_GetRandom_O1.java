class RandomizedSet {
    private Set<Integer> set;
    private List<Integer> list;
    private Random random;

    public RandomizedSet() {
        set = new HashSet<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (!set.contains(val)) {
            set.add(val);
            list.add(val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (set.contains(val)) {
            set.remove(val);
            list.remove(Integer.valueOf(val)); // Remove by value
            return true;
        }
        return false;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
}