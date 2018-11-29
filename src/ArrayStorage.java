import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    int size = size();

    void clear() {
        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        storage[size] = r;
        size += 1;
    }

    Resume get(String uuid) {
        int i = 0;
        while (storage[i] != null && storage[i].uuid != uuid) {
            i += 1;
        }
        return storage[i];
    }

    void delete(String uuid) {
        int i = 0;
        while (i < size && storage[i].uuid != uuid) {
            i += 1;
        }
        for (int j = i; j < size - 1; j += 1) {
            storage[j].uuid = storage[j + 1].uuid;
        }
        storage[size - 1] = null;
        size -= 1;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] st = new Resume[size];
        for (int i = 0; i < size; i += 1) {
            st[i] = storage[i];
        }
        return st;
    }

    int size() {
        int i = 0;
        while (storage[i] != null) {
            i += 1;
        }
        return i;
    }
}
