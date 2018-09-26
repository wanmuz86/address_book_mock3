package my.com.commonroom.addressbook;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class AddressRepository {
    private AddressDao mAddressDao;
    private LiveData<List<Address>> mAllAddresses;

    AddressRepository(Application application) {
        AddressRoomDatabase db = AddressRoomDatabase.getDatabase(application);
        mAddressDao = db.wordDao();
        mAllAddresses = mAddressDao.getAllAddresses();
    }

    LiveData<List<Address>> getmAllAddresses() {
        return mAllAddresses;
    }

    public void insert (Address address) {
        new insertAsyncTask(mAddressDao).execute(address);
    }

    private static class insertAsyncTask extends AsyncTask<Address, Void, Void> {

        private AddressDao mAsyncTaskDao;

        insertAsyncTask(AddressDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Address... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
