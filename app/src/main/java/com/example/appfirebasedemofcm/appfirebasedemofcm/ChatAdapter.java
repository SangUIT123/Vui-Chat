package com.example.appfirebasedemofcm.appfirebasedemofcm;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    private static final int CHAT_END = 1;
    private static final int CHAT_START = 2;

    private List<ChatMode> mDataSet;
    private String mId;

    /**
     * Called when a view has been clicked.
     *
     * @param dataSet Message list
     * @param id      Device id
     */
    ChatAdapter(List<ChatMode> dataSet, String id) {
        mDataSet = dataSet;
        mId = id;
    }

    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;

        if (viewType == CHAT_END) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_received, parent, false);
        } else
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_sent, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public int getItemViewType(int position) {
        if (mDataSet.get(position).getId().equals(mId)) {
            return CHAT_END;
        }

        return CHAT_START;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ChatMode chat = mDataSet.get(position);
        holder.mTextView.setText(chat.getMessage());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    /**
     * Inner Class for a recycler view
     */
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        ViewHolder(View v) {
            super(v);
            //mTextView = (TextView) itemView.findViewById(R.id.);
        }
    }
}
