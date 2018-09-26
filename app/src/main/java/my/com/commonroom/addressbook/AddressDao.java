package my.com.commonroom.addressbook;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface AddressDao {

    @Insert
    void insert(Address address);

    @Query("DELETE from address_table")
    void deleteAll();

    @Query("SELECT * from address_table ORDER BY id ASC")
    LiveData<List<Address>> getAllAddresses();
}
