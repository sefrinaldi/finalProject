import React from 'react';
import { View, Text, TouchableOpacity, StyleSheet } from 'react-native';
import { IconInbox, IconInboxActive } from '../../../assets';
import { colors } from '../../../utils';
import TabItem from '../TabItem';

const BottomNavigator = ({ state, descriptors, navigation }) => {
  return (
    <View style={styles.container}>
      {state.routes.map((route, index) => {
        const { options } = descriptors[route.key];
        const label =
          options.tabBarLabel !== undefined
            ? options.tabBarLabel
            : options.title !== undefined
            ? options.title
            : route.name;

        const isFocused = state.index === index;

        const onPress = () => {
          const event = navigation.emit({
            type: 'tabPress',
            target: route.key,
            canPreventDefault: true,
          });

          if (!isFocused && !event.defaultPrevented) {
            // The `merge: true` option makes sure that the params inside the tab screen are preserved
            navigation.navigate({ name: route.name, merge: true });
          }
        };

        const onLongPress = () => {
          navigation.emit({
            type: 'tabLongPress',
            target: route.key,
          });
        };

        return (
          <TabItem 
            key={index}
            label={label}
            onPress={onPress}
            onLongPress={onLongPress}
            isFocused={isFocused}
          />
        );
      })}
    </View>
  );
}

const styles = StyleSheet.create({
  container : {
    flexDirection: 'row',
    position: 'absolute',
    left: 0,
    bottom: 0,
    right: 0,
    backgroundColor: colors.primary,
    paddingVertical: 8,
    paddingHorizontal: 30,
    justifyContent: 'space-between'
  }
})

export default BottomNavigator;