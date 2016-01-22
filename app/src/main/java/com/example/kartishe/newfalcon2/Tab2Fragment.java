package com.example.kartishe.newfalcon2;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.SeriesSelection;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

import java.util.ArrayList;

/**
 * Created by kartishe on 10/14/15.
 */
public class Tab2Fragment extends Fragment implements View.OnClickListener{

    public static final int[] JOYFUL_COLORS = {
            Color.rgb(67,115,192), Color.rgb(67,192,100),
            Color.rgb(217, 80, 138), Color.rgb(254, 149, 7), Color.rgb(254, 247, 120),
            Color.rgb(106, 167, 134), Color.rgb(53, 194, 209)
    };
    private static int[] COLORS = new int[] { JOYFUL_COLORS[0], JOYFUL_COLORS[1],JOYFUL_COLORS[2],JOYFUL_COLORS[3],};
    private static double[] VALUES = new double[] { 72000,10000 };

    private static String[] NAME_LIST = new String[] { "Packets In","Packets Out" };

    private CategorySeries mSeries = new CategorySeries("");

    private DefaultRenderer mRenderer = new DefaultRenderer();

    private CategorySeries mSeries1 = new CategorySeries("");

    private DefaultRenderer mRenderer1 = new DefaultRenderer();

    private GraphicalView mChartView;
    private GraphicalView mChartView1;

    private ToggleButton img_interface1;
    private ToggleButton img_interface2;
    private ToggleButton img_interface3;

    private LineChart interfaceLineChart;
    @Override
    @TargetApi(16)
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(
                R.layout.interface_layout, container, false);

        interfaceLineChart = (LineChart) rootView.findViewById(R.id.interfaceLineChart);
        setData(20, 30);
        interfaceLineChart.animateX(2500);
        interfaceLineChart.invalidate();

        //((TextView) rootView.findViewById(android.R.id.text1)).setText(
        //        "Interface Stats");

        img_interface1 = (ToggleButton) rootView.findViewById(R.id.image_interface1);
        img_interface2 = (ToggleButton) rootView.findViewById(R.id.image_interface2);
        img_interface3 = (ToggleButton) rootView.findViewById(R.id.image_interface3);
        Boolean hostAvailable = true;

        Drawable green = ContextCompat.getDrawable(getActivity().getBaseContext(), R.drawable.green);
        Drawable red = ContextCompat.getDrawable(getActivity().getBaseContext(),R.drawable.red);

        img_interface1.setOnClickListener(this);
        img_interface2.setOnClickListener(this);
        img_interface3.setOnClickListener(this);

        //write logic to set the interfaces based on rest api results
        img_interface1.setBackground(red);
        img_interface2.setBackground(red);
        img_interface3.setBackground(red);

        mRenderer.setApplyBackgroundColor(true);
        //mRenderer.setBackgroundColor(Color.parseColor("#ffffff"));

        mRenderer.setLabelsTextSize(25);
        mRenderer.setLegendTextSize(25);
        mRenderer.setMargins(new int[]{20, 30, 15, 0});
        mRenderer.setZoomButtonsVisible(false);
        mRenderer.setStartAngle(90);

        //mrenderer.setChartTitle("Efforts");
        //mrenderer.setChartTitleTextSize((float) 30);
        mRenderer.setShowLabels(false);
        //renderer.setLabelsTextSize(20);
        //renderer.setLegendTextSize(25);
        mRenderer.setDisplayValues(true);

        if (mSeries.getItemCount() !=VALUES.length) {
            for (int i = 0; i < VALUES.length; i++) {
                mSeries.add(NAME_LIST[i] + " ", VALUES[i]);
                SimpleSeriesRenderer renderer = new SimpleSeriesRenderer();
                renderer.setColor(COLORS[i]);
                renderer.setDisplayBoundingPoints(false);
                mRenderer.addSeriesRenderer(renderer);
            }
        }
/*
        LinearLayout layout = (LinearLayout) rootView.findViewById(R.id.image12);
        mChartView = ChartFactory.getPieChartView(getActivity().getBaseContext(), mSeries, mRenderer);
        mRenderer.setClickEnabled(true);
        mRenderer.setSelectableBuffer(10);
        layout.addView(mChartView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        if (mChartView != null) {
            mChartView.repaint();
        }
*/
        return rootView;
    }

    private void setData(int count, float range) {

        ArrayList<String> xVals = new ArrayList<String>();
        for (int i = 0; i < count; i++) {
            xVals.add((i) + "");
        }

        ArrayList<Entry> yVals1 = new ArrayList<Entry>();

        for (int i = 0; i < count; i++) {
            float mult = range / 2f;
            float val = (float) (Math.random() * mult) + 50;// + (float)
            // ((mult *
            // 0.1) / 10);
            yVals1.add(new Entry(val, i));
        }

        // create a dataset and give it a type
        LineDataSet set1 = new LineDataSet(yVals1, "GE 1");
        set1.setAxisDependency(YAxis.AxisDependency.LEFT);
        set1.setColor(ColorTemplate.getHoloBlue());
        set1.setCircleColor(Color.WHITE);
        set1.setLineWidth(2f);
        //set1.setCircleRadius(3f);
        set1.setFillAlpha(65);
        set1.setFillColor(ColorTemplate.getHoloBlue());
        set1.setHighLightColor(Color.rgb(244, 117, 117));
        set1.setDrawCircleHole(false);
        //set1.setFillFormatter(new MyFillFormatter(0f));
//        set1.setDrawHorizontalHighlightIndicator(false);
//        set1.setVisible(false);
//        set1.setCircleHoleColor(Color.WHITE);

        ArrayList<Entry> yVals2 = new ArrayList<Entry>();

        for (int i = 0; i < count; i++) {
            float mult = range;
            float val = (float) (Math.random() * mult) + 450;// + (float)
            // ((mult *
            // 0.1) / 10);
            yVals2.add(new Entry(val, i));
        }

        // create a dataset and give it a type
        LineDataSet set2 = new LineDataSet(yVals2, "Tunnel");
        set2.setAxisDependency(YAxis.AxisDependency.RIGHT);
        set2.setColor(Color.RED);
        set2.setCircleColor(Color.WHITE);
        set2.setLineWidth(2f);
        //set2.setCircleRadius(3f);
        set2.setFillAlpha(65);
        set2.setFillColor(Color.RED);
        set2.setDrawCircleHole(false);
        set2.setHighLightColor(Color.rgb(244, 117, 117));
        //set2.setFillFormatter(new MyFillFormatter(900f));


        ArrayList<LineDataSet> dataSets = new ArrayList<LineDataSet>();
        dataSets.add(set2);
        dataSets.add(set1); // add the datasets

        // create a data object with the datasets
        LineData data = new LineData(xVals, dataSets);
        data.setValueTextColor(Color.WHITE);
        data.setValueTextSize(9f);

        // set data
        interfaceLineChart.setData(data);
    }

    @TargetApi(16)
    public void onClick(View v) {
        final Drawable green = ContextCompat.getDrawable(getActivity().getBaseContext(), R.drawable.green);
        final Drawable red = ContextCompat.getDrawable(getActivity().getBaseContext(),R.drawable.red);

        switch(v.getId()){
            case R.id.image_interface1:
                if(img_interface1.isChecked())
                    img_interface1.setBackground(green);
                else
                    img_interface1.setBackground(red);
                break;

            case R.id.image_interface2:
                if(img_interface2.isChecked())
                    img_interface2.setBackground(green);
                else
                    img_interface2.setBackground(red);
                break;

            case R.id.image_interface3:
                if(img_interface3.isChecked())
                    img_interface3.setBackground(green);
                else
                    img_interface3.setBackground(red);
                break;


        }
    }
}
