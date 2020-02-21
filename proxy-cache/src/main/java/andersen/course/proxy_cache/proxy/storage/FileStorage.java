package andersen.course.proxy_cache.proxy.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Кеш результата в файле.
 */
public class FileStorage implements IStorage {

    /** Файл, в который кешируется результат */
    private final File storage;

    public FileStorage(File aPath) {
        storage = aPath;
    }

    @Override
    public Object get(String aKey) {
        File file = new File(storage, aKey);
        try (ObjectInputStream objectInputStream =
                new ObjectInputStream(new FileInputStream(file))) {
            return ((SerializableMethodResult) objectInputStream.readObject()).getMethodResult();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Не удалось десериализовать результат метода");
            return null;
        }
    }

    @Override
    public void cache(String aKey, Object aValue) throws NotSerializableException {
        File file = new File(storage, aKey);
        try (ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(new FileOutputStream(file))) {
            file.createNewFile();
            objectOutputStream.writeObject(new SerializableMethodResult(aValue));
        } catch (NotSerializableException e) {
            throw new NotSerializableException();
        } catch (IOException e) {
            System.err.println("Не удалось сериализовать результат метода в файл");
        }
    }

    @Override
    public boolean isCached(String aKey) {
        File file = new File(storage, aKey);
        return file.exists();
    }

}
