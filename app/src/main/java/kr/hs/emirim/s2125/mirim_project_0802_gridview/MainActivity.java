package kr.hs.emirim.s2125.mirim_project_0802_gridview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    GridView gridv;
    int[] posterId={R.drawable.dr, R.drawable.exo, R.drawable.kn, R.drawable.pp, R.drawable.w,
            R.drawable.error, R.drawable.hunt, R.drawable.mini, R.drawable.topgun, R.drawable.summer,
            R.drawable.dr, R.drawable.exo, R.drawable.kn, R.drawable.pp, R.drawable.w,
            R.drawable.error, R.drawable.hunt, R.drawable.mini, R.drawable.topgun, R.drawable.summer,
            R.drawable.dr, R.drawable.exo, R.drawable.kn, R.drawable.pp, R.drawable.w, R.drawable.error,
            R.drawable.hunt, R.drawable.mini, R.drawable.topgun, R.drawable.summer};
    String[] posterName={"극장판 도라에몽-진구의 우주소전쟁 리틀스타워즈 2021 ","비욘드 라이브 더 무비 : 엑소의 사다리 타고 세계여행3",
    "명탐정 코난-할로윈의 신부","뽀로로 극장판 드래곤캐슬 대모험","외계+인 1부","시맨틱 에러-더 무비","헌트","미니언즈2","탑건-매버릭", "썸머 필름을 타고!",
            "극장판 도라에몽-진구의 우주소전쟁 리틀스타워즈 2021 ","비욘드 라이브 더 무비 : 엑소의 사다리 타고 세계여행3",
            "명탐정 코난-할로윈의 신부","뽀로로 극장판 드래곤캐슬 대모험","외계+인 1부","시맨틱 에러-더 무비","헌트","미니언즈2","탑건-매버릭", "썸머 필름을 타고!",
            "극장판 도라에몽-진구의 우주소전쟁 리틀스타워즈 2021 ","비욘드 라이브 더 무비 : 엑소의 사다리 타고 세계여행3",
            "명탐정 코난-할로윈의 신부","뽀로로 극장판 드래곤캐슬 대모험","외계+인 1부","시맨틱 에러-더 무비","헌트","미니언즈2","탑건-매버릭", "썸머 필름을 타고!"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("최신영화포스터(CGV)");
        gridv = findViewById(R.id.gridv);
        PosterAdapter adapter = new PosterAdapter(this);
        gridv.setAdapter(adapter);
    }
    public class PosterAdapter extends BaseAdapter{
        Context context;
        public PosterAdapter(Context context){
            this.context = context;
        }

        @Override
        public int getCount() {
            return posterId.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imgv = new ImageView(context);
            ViewGroup.LayoutParams params = new GridView.LayoutParams(200,300);
            imgv.setLayoutParams(params);
            imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imgv.setPadding(5,5,5,5);
            imgv.setImageResource(posterId[i]);
            final int pos = i;
            imgv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    dlg.setTitle(posterName[pos]);
                    dlg.setIcon(R.drawable.movie);
                    View dlgView = View.inflate(MainActivity.this, R.layout.dialog,null);
                    ImageView imgvDlg = dlgView.findViewById(R.id.imgv_dlg);
                    imgvDlg.setImageResource(posterId[pos]);
                    dlg.setView(dlgView);
                    dlg.setNegativeButton("close",null);
                    dlg.show();
                }
            });
            return imgv;
        }
    }
}