package my.com.commonroom.addressbook;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AddressListAdapter extends RecyclerView.Adapter<AddressListAdapter.AddressViewHolder> {

    private final LayoutInflater mInflater;
    private List<Address> mAddresses; // Cached copy of words


    AddressListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public AddressViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.custom_row, parent, false);
        return new AddressViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AddressViewHolder holder, int position) {
        if (mAddresses != null) {
            Address current = mAddresses.get(position);
            holder.addressTextView.setText(current.getAddress1());
            holder.phoneTextView.setText(current.getPhone());
            holder.nameTextView.setText(current.getFirstName()+" "+current.getLastName());
        } else {
            // Covers the case of data not being ready yet.
            holder.nameTextView.setText("No Address");
        }
    }

    void setAddresses(List<Address> addresses){
        mAddresses = addresses;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mAddresses != null)
            return mAddresses.size();
        else return 0;
    }

    class AddressViewHolder extends RecyclerView.ViewHolder {
        private final TextView addressTextView;
        private final TextView phoneTextView;
        private final ImageView imageView;
        private final TextView nameTextView;

        private AddressViewHolder(View itemView) {
            super(itemView);
            addressTextView = itemView.findViewById(R.id.addressTextView);
            phoneTextView = itemView.findViewById(R.id.phoneTextView);
            imageView = itemView.findViewById(R.id.userImageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);

        }

    }
}
