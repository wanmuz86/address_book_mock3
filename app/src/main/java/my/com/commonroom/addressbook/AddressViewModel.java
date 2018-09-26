package my.com.commonroom.addressbook;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class AddressViewModel extends AndroidViewModel{
    private AddressRepository mRepository;

    private LiveData<List<Address>> mAllAddresses;

    public AddressViewModel (Application application) {
        super(application);
        mRepository = new AddressRepository(application);
        mAllAddresses = mRepository.getmAllAddresses();
    }

    LiveData<List<Address>> getAllAddresses() { return mAllAddresses; }

    public void insert(Address address) { mRepository.insert(address); }
}

