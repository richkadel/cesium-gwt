package org.cesiumjs.cesium.data;


public final class EntityDataSource extends DataSource
{
  protected EntityDataSource() {}
  
  public static native EntityDataSource create(EntityCollection entityCollection, String name) /*-{
  
    var EntityDataSource = function(entityCollection, name) {
      this._name = name;
      this._changed = new Cesium.Event();
      this._error = new Cesium.Event();
      this._isLoading = false;
      this._loading = new Cesium.Event();
      this._clock = undefined;
      this._version = undefined; // should this be in defineProperties?
      this._entityCollection = entityCollection
      
      var availability = this._entityCollection.computeAvailability();
      if (!availability.start.equals(Cesium.Iso8601.MINIMUM_VALUE)) {
        var startTime = availability.start;
        var stopTime = availability.stop;
        var totalSeconds = Cesium.JulianDate.secondsDifference(stopTime, startTime);
        var multiplier = Math.round(totalSeconds / 120.0);
  
        var clock = new Cesium.DataSourceClock();
        clock.startTime = Cesium.JulianDate.clone(startTime);
        clock.stopTime = Cesium.JulianDate.clone(stopTime);
        clock.clockRange = Cesium.ClockRange.LOOP_STOP;
        clock.multiplier = multiplier;
        clock.currentTime = Cesium.JulianDate.clone(startTime);
        clock.clockStep = Cesium.ClockStep.SYSTEM_CLOCK_MULTIPLIER;
        this._clock = clock;
      }
    };
    
    Cesium.defineProperties(EntityDataSource.prototype, {
      name : {
        get : function() {
          return this._name;
        }
      },
      clock : {
        get : function() {
          return this._clock;
        }
      },
      entities : {
        get : function() {
          return this._entityCollection;
        }
      },
      isLoading : {
        get : function() {
          return this._isLoading;
        }
      },
      changedEvent : {
        get : function() {
          return this._changed;
        }
      },
      errorEvent : {
        get : function() {
          return this._error;
        }
      },
      loadingEvent : {
        get : function() {
          return this._loading;
        }
      }
    });
    
    return new EntityDataSource(entityCollection, name)
  }-*/;
  
}
