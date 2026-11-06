				import java.util.ArrayList;
				import java.util.HashMap;
				import java.util.List;
				import java.util.Map;
				import java.util.PriorityQueue;

				public class TopKFreqElements {
					public List<String> topKFrequent(String[] fruits, int k) {
						Map<String, Integer> frequencies = new HashMap<>();
						for (String fruit : fruits) {
							frequencies.put(fruit, frequencies.getOrDefault(fruit, 0) + 1);
						}

						PriorityQueue<String> minHeap = new PriorityQueue<>(
								(first, second) -> frequencies.get(first) - frequencies.get(second));
						for (String fruit : frequencies.keySet()) {
							minHeap.offer(fruit);
							if (minHeap.size() > k) {
								minHeap.poll();
							}
						}

						List<String> result = new ArrayList<>();
						while (!minHeap.isEmpty()) {
							result.add(minHeap.poll());
						}
						return result;
					}

					public static void main(String[] args) {
						String[] fruits = {"apple", "banana", "apple", "orange", "banana", "apple"};
						System.out.println(new TopKFreqElements().topKFrequent(fruits, 2));
					}
				}
                