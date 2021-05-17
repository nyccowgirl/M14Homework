
public class VoterHashTableSeparateChaining {

	public Node<Voter>[] hashTable; // made public for testing purposes only!
	public int tableSize; 		    // made public for testing purposes only!

	public VoterHashTableSeparateChaining(int size) {
		hashTable = (Node<Voter>[]) new Node[size];
		tableSize = size;
	}
	
	public int getHashTableLocation(int voterID) {
		return voterID % hashTable.length;
	}

	public boolean addVoter(Voter voterToAdd) {
		int index = getHashTableLocation(voterToAdd.getId());

		if (hashTable[index] == null) {
			hashTable[index] = new Node(voterToAdd);
		} else {
			Node current = hashTable[index];
			while (current != null) {
				// completing extra credit
				Voter temp = (Voter) current.getData();
				if (temp.getId() == voterToAdd.getId()) {
					return false;
				}

				if (current.getNextNode() != null) {
					current = current.getNextNode();
				} else {
					current.setNextNode(new Node(voterToAdd));
					current = current.getNextNode().getNextNode();
				}
			}
		}
		return true;
	}

	public Voter getVoter(int voterID) {
		int location = getHashTableLocation(voterID);
		Node current = hashTable[location];

		while (current != null) {
			Voter temp = (Voter) current.getData();
			if (temp.getId() == voterID) {
				return temp;
			}
			current = current.getNextNode();
		}

		return null;
	}

	public void printTable() {
		for (int i = 0; i < tableSize; i++) {
			if (hashTable[i] != null) {
				System.out.print("Location " + i + ": ");
				Node<Voter> current = hashTable[i];
				while (current != null && current.next != null) {
					System.out.print(current.data.getName() + " -> ");
					current = current.next;
				}
				System.out.println(current.data.getName());
			}
		}
	}

}
