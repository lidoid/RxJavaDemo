package app.rxjavademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    String TAG = "mainactivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
//                for (int i = 0; i <= 3; i++) {
//                    e.onNext(i);
//                }
//                e.onComplete();
//            }
//        });
//        Observer<Integer> observer = new Observer<Integer>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//                Log.d(TAG, "subscribe");
//            }
//
//            @Override
//            public void onNext(@NonNull Integer integer) {
//                Log.d(TAG, integer + "");
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//                Log.d(TAG, "error");
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "complete");
//            }
//        };
//        observable.subscribe(observer);

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                for (int i = 0; i <= 3; i++) {
                    e.onNext(i);
                }
                e.onComplete();
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d(TAG, "subscribe");
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Log.d(TAG, "" + integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "error");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "complete");
            }
        });
    }
}
