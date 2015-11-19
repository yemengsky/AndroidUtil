1、
listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState) {
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE: // 停止滚动
                        ImageLoader.getInstance().resume();
                        break;
                    case AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL: // 正在滚动
                    case AbsListView.OnScrollListener.SCROLL_STATE_FLING: // 手指做了抛的动作（手指离开屏幕前，用力滑了一下）
                    default:
                        ImageLoader.getInstance().pause();
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                if (firstVisibleItem == 0) {

                }

                if (!isGoing && (visibleItemCount + firstVisibleItem == totalItemCount)) {
                    if (curPage < pageCount) {
                        footView.setVisibility(View.VISIBLE);
                        //listView.addFooterView(footView);
                        initHttp(MORE);
                    } else {
                        footView.setText(getResources().getString(R.string.load_finish));
                        footView.setVisibility(View.VISIBLE);
                    }
                } else {
                    footView.setVisibility(View.VISIBLE);
                    footView.setText(getResources().getString(R.string.load_more));
                }
            }
        });
