package com.example.kartishe.newfalcon2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

import java.util.ArrayList;

/**
 * Created by kartishe on 10/14/15.
 */
public class Tab3Fragment extends Fragment {

    public static final int[] JOYFUL_COLORS = {
            Color.rgb(67,115,192), Color.rgb(67,192,100),
            Color.rgb(217, 80, 138), Color.rgb(254, 149, 7), Color.rgb(254, 247, 120),
            Color.rgb(106, 167, 134), Color.rgb(53, 194, 209)
    };
    // Color.rgb(195,192,182),Color.rgb(67,115,192),
    private static int[] COLORS = new int[] { JOYFUL_COLORS[0], JOYFUL_COLORS[1],JOYFUL_COLORS[2],JOYFUL_COLORS[3],};
    private static double[] VALUES = new double[] { 30,70 };

    private static String[] NAME_LIST = new String[] { "Used", "Free"};

    private CategorySeries mSeries= new CategorySeries("");

    private DefaultRenderer mRenderer = new DefaultRenderer();

    private GraphicalView mChartView;

    private BarChart mChart;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.memory_layout, container, false);
        mChart = (BarChart) v.findViewById(R.id.processBarChart);

        mChart.setDescription("");
        //mChart.setOnChartGestureListener(this);
        //MyMarkerView mv = new MyMarkerView(getActivity(), R.layout.custom_marker_view);
        //mChart.setMarkerView(mv);
        mChart.setHighlightEnabled(false);
        mChart.setDrawGridBackground(false);
        mChart.setDrawBarShadow(false);
        BarData data = new BarData(getXAxisValues(), getDataSet());
        mChart.setData(data);
        mChart.setDescription("My Chart");
        mChart.animateXY(2000, 2000);
        mChart.invalidate();

        return v;
        /*
        Log.d("sheikh","");
        View rootView = inflater.inflate(
                R.layout.memory_layout, container, false);
        //((TextView) rootView.findViewById(android.R.id.text1)).setText(
        //        "Memory Stats");


        mRenderer.setApplyBackgroundColor(true);
        //mRenderer.setBackgroundColor(Color.parseColor("#ffffff"));

        mRenderer.setLabelsTextSize(50);
        mRenderer.setLegendTextSize(50);
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

        LinearLayout layout = (LinearLayout) rootView.findViewById(R.id.image1);
        mChartView = ChartFactory.getPieChartView(getActivity().getBaseContext(), mSeries, mRenderer);
        mRenderer.setClickEnabled(true);
        mRenderer.setSelectableBuffer(10);
        layout.addView(mChartView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        if (mChartView != null) {
            mChartView.repaint();
        }

        return rootView;
        */
    }

    private ArrayList<BarDataSet> getDataSet() {
        ArrayList<BarDataSet> dataSets = null;

        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
        BarEntry v1e1 = new BarEntry(110.000f, 0); // Jan
        valueSet1.add(v1e1);
        BarEntry v1e2 = new BarEntry(40.000f, 1); // Feb
        valueSet1.add(v1e2);
        BarEntry v1e3 = new BarEntry(60.000f, 2); // Mar
        valueSet1.add(v1e3);
        BarEntry v1e4 = new BarEntry(30.000f, 3); // Apr
        valueSet1.add(v1e4);
        BarEntry v1e5 = new BarEntry(90.000f, 4); // May
        valueSet1.add(v1e5);
        BarEntry v1e6 = new BarEntry(100.000f, 5); // Jun
        valueSet1.add(v1e6);

        ArrayList<BarEntry> valueSet2 = new ArrayList<>();
        BarEntry v2e1 = new BarEntry(150.000f, 0); // Jan
        valueSet2.add(v2e1);
        BarEntry v2e2 = new BarEntry(90.000f, 1); // Feb
        valueSet2.add(v2e2);
        BarEntry v2e3 = new BarEntry(120.000f, 2); // Mar
        valueSet2.add(v2e3);
        BarEntry v2e4 = new BarEntry(60.000f, 3); // Apr
        valueSet2.add(v2e4);
        BarEntry v2e5 = new BarEntry(20.000f, 4); // May
        valueSet2.add(v2e5);
        BarEntry v2e6 = new BarEntry(80.000f, 5); // Jun
        valueSet2.add(v2e6);

        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "Brand 1");
        barDataSet1.setColors(ColorTemplate.COLORFUL_COLORS);
        //BarDataSet barDataSet2 = new BarDataSet(valueSet2, "Brand 2");
        //barDataSet2.setColors(ColorTemplate.COLORFUL_COLORS);

        dataSets = new ArrayList<>();
        dataSets.add(barDataSet1);
        //dataSets.add(barDataSet2);
        return dataSets;
    }

    private ArrayList<String> getXAxisValues() {
        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("JAN");
        xAxis.add("FEB");
        xAxis.add("MAR");
        xAxis.add("APR");
        xAxis.add("MAY");
        xAxis.add("JUN");
        return xAxis;
    }

}
